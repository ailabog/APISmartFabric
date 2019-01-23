package com.APISmartFabric.Tests.DocumentTemplateRest.GET;

import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public class Documents_Templates_exportSimpleTest48 {

	private static final String processUuid = "708b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private static final String templateUuid = "string";
	private static final String versionId = "508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private static final String invalidProcessUuid = "706782cf1-bc2b-4d4e4576-8d1a-d5fkjl177";
	private static final String invalidTemplateUuid = "dfghfghgf";
	private static final String nullProcessUuid = "null";
	private static final String nullTemplateUuid = "null";
	private static final String invalidVersionId = "50856756f1-bc2b-4drtfyrty4e-8drtyry1a-gfhjghj576574e8177";
	private static final String nullVersionId = "null";


	@Test
	public void getDocumentsTemplatesExportSimple() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + processUuid + "\",\n" + "\"templateUuid\":\"" + templateUuid + "\", \n"
						+ "\"versionId\":\"" + versionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(200);
	}

	@Test
	public void getDocumentsTemplatesExportSimpleInvalidProcessUuid() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + invalidProcessUuid + "\",\n" + "\"templateUuid\":\"" + templateUuid
						+ "\", \n" + "\"versionId\":\"" + versionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);

	}

	@Test
	public void getDocumentsTemplatesExportSimpleInvalidTemplateUuId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + processUuid + "\",\n" + "\"templateUuid\":\"" + invalidTemplateUuid
						+ "\", \n" + "\"versionId\":\"" + versionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);

	}

	@Test
	public void getDocumentsTemplatesExportSimpleInvalidVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + processUuid + "\",\n" + "\"templateUuid\":\"" + templateUuid + "\", \n"
						+ "\"versionId\":\"" + invalidVersionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);

	}

	@Test
	public void getDocumentsTemplatesExportSimpleInvalidProcessUuidInvalidTemplateUuid() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + invalidProcessUuid + "\",\n" + "\"templateUuid\":\"" + invalidTemplateUuid
						+ "\", \n" + "\"versionId\":\"" + versionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);
	}

	@Test
	public void getDocumentsTemplatesExportSimpleInvalidProcessUuidInvalidVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + invalidProcessUuid + "\",\n" + "\"templateUuid\":\"" + templateUuid
						+ "\", \n" + "\"versionId\":\"" + invalidVersionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);
	}

	@Test
	public void getDocumentsTemplatesExportSimpleInvalidTemplatedInvalidVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + processUuid + "\",\n" + "\"templateUuid\":\"" + invalidTemplateUuid
						+ "\", \n" + "\"versionId\":\"" + invalidVersionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);
	}

	@Test
	public void getDocumentsTemplatesExportSimpleInvalidProcessUuidInvalidTemplateUuidInvalidVersionId()
			throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + nullProcessUuid + "\",\n" + "\"templateUuid\":\"" + nullTemplateUuid
						+ "\", \n" + "\"versionId\":\"" + nullVersionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);
	}

	@Test
	public void getDocumentsTemplatesExportSimpleNULLProcessUuid() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + nullProcessUuid + "\",\n" + "\"templateUuid\":\"" + templateUuid + "\", \n"
						+ "\"versionId\":\"" + versionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);

	}

	@Test
	public void getDocumentsTemplatesExportSimpleNULLTemplateUuId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + processUuid + "\",\n" + "\"templateUuid\":\"" + nullTemplateUuid + "\", \n"
						+ "\"versionId\":\"" + versionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);

	}

	@Test
	public void getDocumentsTemplatesExportSimpleNULLVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + processUuid + "\",\n" + "\"templateUuid\":\"" + templateUuid + "\", \n"
						+ "\"versionId\":\"" + nullVersionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);

	}

	@Test
	public void getDocumentsTemplatesExportSimpleNULLProcesseUuidNULLTemplateUuid() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + nullProcessUuid + "\",\n" + "\"templateUuid\":\"" + nullTemplateUuid
						+ "\", \n" + "\"versionId\":\"" + versionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);
	}

	@Test
	public void getDocumentsTemplatesExportSimpleNULLProcesseUuidNULLVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + nullProcessUuid + "\",\n" + "\"templateUuid\":\"" + templateUuid + "\", \n"
						+ "\"versionId\":\"" + nullVersionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);
	}

	@Test
	public void getDocumentsTemplatesExportSimpleInvalidTemplateUuidInvalidVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + processUuid + "\",\n" + "\"templateUuid\":\"" + nullTemplateUuid + "\", \n"
						+ "\"versionId\":\"" + nullVersionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);
	}

	@Test
	public void getDocumentsTemplatesExportSimpleNULLProcessUuidNULLVersionId()
			throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + nullProcessUuid + "\",\n" + "\"templateUuid\":\"" + templateUuid
						+ "\", \n" + "\"versionId\":\"" + nullVersionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(404);
	}

	@Test
	public void getDocumentsTemplatesExportSimpleNoAuthentication() throws FileNotFoundException {
		given().contentType(ContentType.JSON)
				.body("{\"processUid\":\"" + processUuid + "\",\n" + "\"templateUuid\":\"" + templateUuid + "\", \n"
						+ "\"versionId\":\"" + versionId + "\" }")
				.when()
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple"))
				.then().statusCode(401);
	}
}

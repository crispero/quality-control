import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class RestAssuredMagazineUtils {
    public static String BASE_API_URL = "http://52.136.215.164:9000/api";
    public static String PRODUCT_END_POINT = "/products";
    public static String ADD_PRODUCT_END_POINT = "/addproduct";
    public static String EDIT_PRODUCT_END_POINT = "/editproduct";
    public static Integer SUCCESS_STATUS_CODE = 200;

    public void getProductsStatusCode() {
        given().baseUri(BASE_API_URL).when().get(PRODUCT_END_POINT).then().assertThat().statusCode(SUCCESS_STATUS_CODE);
    }
}

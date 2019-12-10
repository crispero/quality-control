import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MagazineTest {

    private RestAssuredMagazineUtils restAssuredMagazineUtils = new RestAssuredMagazineUtils();

    @Test
    void getProductsApiStatusCode_CorrectValue_ReturnSuccessStatusCode() {
        RestAssuredMagazineUtils.getProductsStatusCode();
    }
}

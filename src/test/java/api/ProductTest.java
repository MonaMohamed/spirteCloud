package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomDigits;

public class ProductTest extends BaseApi {
   @Test
    public void ProductDetailsTest(){
       int productId = RandomDigits.generateRandomNumber();
       Response response = RestAssured.post(baseURL+"?id_product="+productId+"&controller=product");
       System.out.println(response.statusCode());
       System.out.println(response.asString());
       System.out.println(response.getBody().asString());
       System.out.println(response.statusLine());

       int statusCode = response.getStatusCode();
       Assert.assertEquals(statusCode, 200);
   }
}

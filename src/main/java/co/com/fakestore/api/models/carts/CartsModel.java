package co.com.fakestore.api.models.carts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartsModel {

    private int id;
    private int userId;
    private List<ProductCart> products;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductCart {
        private int id;
        private String title;
        private double price;
        private String description;
        private String category;
        private String image;
    }
}

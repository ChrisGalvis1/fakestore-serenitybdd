package co.com.fakestore.api.models.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsModel {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

}

package co.com.fakestore.api.utils;

import co.com.fakestore.api.models.users.UserModel;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class UserModelFactory {

    public static UserModel crearDesde(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        return new UserModel(
                Integer.parseInt(data.get("id")),
                data.get("username"),
                data.get("email"),
                data.get("password")
        );
    }
}

package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertProduct(String productName, int price, int stock) {
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO products (product_name, price, stock) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, productName);
            stmt.setInt(2, price);
            stmt.setInt(3, stock);
            return stmt;
        }, keyholder);
        return keyholder.getKey().longValue();
    }

    public Product findProductById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?",
                (rs, rowNum) -> new Product(rs.getLong("id"), rs.getString("product_name"), rs.getInt("price"), rs.getInt("stock")), id);
    }

    public void updateProductStock(long id, int amount) {
        jdbcTemplate.update("UPDATE products SET stock = stock - ? WHERE id = ?", amount, id);
    }
}

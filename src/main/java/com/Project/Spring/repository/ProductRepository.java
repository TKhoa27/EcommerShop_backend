package com.Project.Spring.repository;


import com.Project.Spring.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM products",
                (rs, rowNum) -> new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock_quantity"),
                        rs.getString("category"),
                        rs.getBigDecimal("rating"),
                        rs.getString("image"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                )
        );
    }
}

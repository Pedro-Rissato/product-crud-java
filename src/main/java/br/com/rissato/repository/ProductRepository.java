package br.com.rissato.repository;

import br.com.rissato.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class ProductRepository {
    private Connection getConnection() throws Exception {
        Properties props = new Properties();
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        String URL = System.getenv("DB_URL");

        if (user == null || password == null || URL == null) {
            throw new RuntimeException("Variáveis de ambiente não definidas");
        }
        props.setProperty("user", user);
        props.setProperty("password", password);
        props.setProperty("ssl", "false");

        return DriverManager.getConnection(URL, props);
    }

    public List<Product> findAll() throws Exception {
        String sql = "SELECT * FROM products";

        try (Connection conn = getConnection();
             var stmt = conn.prepareStatement(sql);
             var rs = stmt.executeQuery()) {

            List<Product> products = new ArrayList<>();

            while (rs.next()) {
                Product product = new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock"),
                        rs.getString("description"),
                        rs.getBigDecimal("discountPercentage")
                );
                products.add(product);
            }
            return products;
        }
    }

    public List<Product> findById(Long id) throws Exception {
        String sql = "SELECT * FROM products WHERE id =?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                return Collections.singletonList(new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock"),
                        rs.getString("description"),
                        rs.getBigDecimal("discountPercentage")));

            }
            return null;
        }
    }

    public void deleteById(Long id) throws Exception {
        String sql = "DELETE FROM products WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    public void save(Product product) throws Exception {
        String sql = "INSERT INTO products (name, price, stock, description) VALUES(?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setBigDecimal(2, product.getPrice());
            stmt.setInt(3, product.getStock());
            stmt.setString(4, product.getDescription());

            stmt.executeUpdate();
        }
    }

    public void update(Product product) throws Exception {
        String sql = "UPDATE products SET name=? ,price=?, stock=?, description=?, discountPercentage=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setBigDecimal(2, product.getPrice());
            stmt.setInt(3, product.getStock());
            stmt.setString(4, product.getDescription());
            stmt.setBigDecimal(5, product.getDiscountPercentage());
            stmt.setLong(6, product.getId());

            stmt.executeUpdate();
        }
    }
}


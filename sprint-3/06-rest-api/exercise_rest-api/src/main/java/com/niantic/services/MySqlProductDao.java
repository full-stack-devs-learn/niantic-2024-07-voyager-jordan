package com.niantic.services;

import com.niantic.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MySqlProductDao implements ProductDao
{
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    MySqlProductDao(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource); }

    public List<Product> getAllProducts()
    {
        List<Product> result = new ArrayList<>();

        String query = """
                    SELECT *
                    FROM products
                    """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(query);

        while(row.next())
        {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int supplierId = row.getInt("supplier_id");
            int categoryId = row.getInt("category_id");
            String description = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");
            boolean isDiscontinued = row.getBoolean("discontinued");

            Product product = new Product(
                                            productId,
                                            productName,
                                            supplierId,
                                            categoryId,
                                            description,
                                            unitPrice,
                                            unitsInStock,
                                            unitsOnOrder,
                                            reorderLevel,
                                            isDiscontinued
            );

            result.add(product);
        }

        return result;
    }

    public Product getProductById(int productId)
    {
        String query = """
                    SELECT *
                    FROM products
                    WHERE product_id = ?
                    """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(query, productId);

        if(row.next())
        {
            productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int supplierId = row.getInt("supplier_id");
            int categoryId = row.getInt("category_id");
            String description = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");
            boolean isDiscontinued = row.getBoolean("discontinued");

            Product product = new Product(
                    productId,
                    productName,
                    supplierId,
                    categoryId,
                    description,
                    unitPrice,
                    unitsInStock,
                    unitsOnOrder,
                    reorderLevel,
                    isDiscontinued
            );

            return product;
        }
        return null;
    }

    public Product getProductByName(String productName)
    {
        String query = """
                    SELECT *
                    FROM products
                    WHERE product_name = ?
                    """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(query, productName);

        if(row.next())
        {
            int productId = row.getInt("product_id");
            productName = row.getString("product_name");
            int supplierId = row.getInt("supplier_id");
            int categoryId = row.getInt("category_id");
            String description = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");
            boolean isDiscontinued = row.getBoolean("discontinued");

            Product product = new Product(
                    productId,
                    productName,
                    supplierId,
                    categoryId,
                    description,
                    unitPrice,
                    unitsInStock,
                    unitsOnOrder,
                    reorderLevel,
                    isDiscontinued
            );

            return product;
        }
        return null;
    }

    public List<Product> getProductsByCategoryId(int categoryId)
    {
        List<Product> result = new ArrayList<>();

        String query = """
                    SELECT *
                    FROM products
                    WHERE category_id = ?
                    """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(query, categoryId);

        while(row.next())
        {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int supplierId = row.getInt("supplier_id");
            categoryId = row.getInt("category_id");
            String description = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");
            boolean isDiscontinued = row.getBoolean("discontinued");

            Product product = new Product(
                    productId,
                    productName,
                    supplierId,
                    categoryId,
                    description,
                    unitPrice,
                    unitsInStock,
                    unitsOnOrder,
                    reorderLevel,
                    isDiscontinued
            );

            result.add(product);
        }
        return result;
    }

    public Product addProduct(Product product) {
        String query = """
                    INSERT INTO products (product_name, supplier_id, category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued)
                    VALUES (?,?,?,?,?,?,?,?,?)
                    """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getSupplierId());
            statement.setInt(3, product.getCategoryId());
            statement.setString(4, product.getDescription());
            statement.setDouble(5, product.getUnitPrice());
            statement.setInt(6, product.getUnitsInStock());
            statement.setInt(7, product.getUnitsOnOrder());
            statement.setInt(8, product.getReorderLevel());
            statement.setBoolean(9, product.isDiscontinued());
            return statement;
        }, keyHolder);

        int newId = keyHolder.getKey().intValue();
        return getProductById(newId);
    }

    public void updateProduct(int productId, Product product)
    {
        String query = """
                UPDATE products
                SET product_name = ?
                    , supplier_id = ?
                    , category_id = ?
                    , quantity_per_unit = ?
                    , unit_price = ?
                    , units_in_stock = ?
                    , units_on_order = ?
                    , reorder_level = ?
                    , discontinued = ?
                WHERE product_id = ?
                """;

        jdbcTemplate.update(query
                , product.getProductName()
                , product.getSupplierId()
                , product.getCategoryId()
                , product.getDescription()
                , product.getUnitPrice()
                , product.getUnitsInStock()
                , product.getUnitsOnOrder()
                , product.getReorderLevel()
                , product.isDiscontinued()
                , productId
        );
    }

    public void deleteProduct(int productId)
    {
        String query = """
                DELETE FROM products
                WHERE product_id = ?
                """;

        jdbcTemplate.update(query, productId);
    }
}

package com.niantic.services;

import com.niantic.models.Category;
import com.niantic.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class ProductDao
{
    private final JdbcTemplate jdbcTemplate;

    public ProductDao()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
    Return a list of all Products with the specified categoryId
     */
    public ArrayList<Product> getProductsByCategory(int categoryId)
    {
        var products = new ArrayList<Product>();

        String sql = """
                SELECT *
                FROM products
                WHERE category_id = ?
                """;

        var row = jdbcTemplate.queryForRowSet(sql, categoryId);

        while(row.next()){
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int productCategoryId = row.getInt("category_id");
            String quantityPerItem = row.getString("quantity_per_unit");
            double productUnitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            var product = new Product(
                    productId
                    ,productCategoryId
                    ,productName
                    ,quantityPerItem
                    ,productUnitPrice
                    ,unitsInStock
                    ,unitsOnOrder
                    ,reorderLevel
            );
            products.add(product);

        }
        return products;
    }

    /*
    Find and return a Product by Id
     */
    public Product getProduct(int search_productId)
    {

        // <editor-fold desc="Select Statement & Query">
        String sql = """
                       SELECT product_id
                       ,category_id
                       ,product_name
                       ,quantity_per_unit
                       ,unit_price
                       ,units_in_stock
                       ,units_on_order
                       ,reorder_level
                       FROM products
                       WHERE product_id = ?
                     """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, search_productId);

        if(row.next()) {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int productCategoryId = row.getInt("category_id");
            String quantityPerItem = row.getString("quantity_per_unit");
            double productUnitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            var product = new Product(
                    productId
                    , productCategoryId
                    , productName
                    , quantityPerItem
                    , productUnitPrice
                    , unitsInStock
                    , unitsOnOrder
                    , reorderLevel
            );
            return product;
        }
        return null;
    }

    /*
    Add a new product
     */
    public void addProduct(Product product)
    {
        String sql = """
                       INSERT INTO products
                       (product_name, category_id, unit_price, units_in_stock, units_on_order, reorder_level, quantity_per_unit)
                       VALUES (?,?,?,?,?,?)
                     """;

        jdbcTemplate.update(sql
                            , product.getProductName()
                            , product.getCategoryId()
                            , product.getUnitPrice()
                            , product.getUnitsInStock()
                            , product.getUnitsOnOrder()
                            , product.getReorderLevel()
                            , product.getQuantityPerUnit()
        );

    }

    /*
    Update product by Id
     */
    public void updateProduct(Product product)
    {
        String sql = """
                UPDATE products
                SET product_name = ?
                    , category_id = ?
                    , unit_price = ?
                    , units_in_stock = ?
                    , units_on_order = ?
                    , reorder_level = ?
                    , quantity_per_unit = ?
                WHERE product_id = ?;
                """;

        jdbcTemplate.update(sql
                , product.getProductName()
                , product.getCategoryId()
                , product.getUnitPrice()
                , product.getUnitsInStock()
                , product.getUnitsOnOrder()
                , product.getReorderLevel()
                , product.getQuantityPerUnit()
                , product.getProductId() //At the product id
        );
    }

    /*
    Delete a product by Id
     */
    public void deleteProduct(int id)
    {
        String sql = "DELETE FROM products WHERE product_id = ?;";

        jdbcTemplate.update(sql, id);
    }

}

package entity;

import java.util.Scanner;

public class Products implements IApp {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    public Products() {}

    public Products(String productId, String productName, float importPrice, float exportPrice, String title, String description, int quantity, int categoryId, int status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.status = status;
    }

    private boolean isDuplicateProduct(Products[] existingProducts, String id, String name, String currentId) {
        if (id == null || name == null) return false;

        for (Products p : existingProducts) {
            if (p != null && !p.getProductId().equalsIgnoreCase(currentId)) {
                if (p.getProductId().equalsIgnoreCase(id) || p.getProductName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidCategory(Categories[] existingCategories, int categoryId) {
        for (Categories c : existingCategories) {
            if (c != null && c.getCateId() == categoryId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void inputData(Scanner scanner, Categories[] existingCategories, Products[] existingProducts) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (5 ký tự, bắt đầu bằng C, E, T): ");
            productId = scanner.nextLine().trim();
            if (!productId.matches("[CET][A-Za-z0-9]{4}") || isDuplicateProduct(existingProducts, productId, "",productId)) {
                System.out.println("Mã sản phẩm không hợp lệ hoặc đã tồn tại, vui lòng nhập lại!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Nhập tên sản phẩm (10-100 ký tự, không trùng): ");
            productName = scanner.nextLine().trim();
            if (productName.length() < 10 || productName.length() > 100 || isDuplicateProduct(existingProducts, "", productName,productId)) {
                System.out.println("Tên sản phẩm không hợp lệ hoặc đã tồn tại, vui lòng nhập lại!");
            } else {
                break;
            }
        }

        System.out.print("Nhập giá nhập sản phẩm: ");
        importPrice = scanner.nextFloat();
        System.out.print("Nhập giá xuất sản phẩm (>= giá nhập * INTEREST): ");
        exportPrice = scanner.nextFloat();

        scanner.nextLine();
        System.out.print("Nhập tiêu đề sản phẩm (tối đa 200 ký tự): ");
        title = scanner.nextLine();
        System.out.print("Nhập mô tả sản phẩm: ");
        description = scanner.nextLine();
        System.out.print("Nhập số lượng sản phẩm: ");
        quantity = scanner.nextInt();
        System.out.print("Nhập mã danh mục: ");
        categoryId = scanner.nextInt();

        if (!isValidCategory(existingCategories, categoryId)) {
            System.out.println("Mã danh mục không hợp lệ!");
        }

        System.out.print("Nhập trạng thái (0 - Đang hoạt động, 1 - Hết hàng, 2 - Không hoạt động): ");
        status = scanner.nextInt();
    }

    @Override
    public void displayData() {
        System.out.println(productId + " - " + productName + " - " + exportPrice + " - " + quantity + " - Danh mục: " + categoryId + " - " + status);
    }

    public String getProductId() {
        return productId;
    };

    public String getProductName() {
        return productName;
    }


    public String getTitle() {
        return title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

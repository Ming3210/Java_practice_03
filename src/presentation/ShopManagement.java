package presentation;

import entity.Categories;
import entity.Products;

import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Categories[] categoriesList = new Categories[100];
        Products[] productsList = new Products[100];
        int categoryCount = 0;
        int productCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*************** SHOP MENU ***************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    categoryManagement(scanner, categoriesList, productsList, categoryCount);
                    break;
                case 2:
                    productManagement(scanner, categoriesList, productsList, productCount);
                    break;
                case 3:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Chọn sai, vui lòng nhập lại!");
            }
        }
    }

    private static void categoryManagement(Scanner scanner, Categories[] categories, Products[] products, int count) {
        while (true) {
            System.out.println("\n********** CATEGORIE MANAGEMENT **********");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (Categories c : categories) {
                        if (c != null) c.displayData();
                    }
                    break;
                case 2:
                    Categories newCategory = new Categories();
                    newCategory.inputData(scanner, categories, products);
                    categories[count++] = newCategory;
                    System.out.println("Danh mục đã được thêm!");
                    break;
                case 3:
                    System.out.print("Nhập mã danh mục cần cập nhật: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    for (Categories c : categories) {
                        if (c != null && c.getCateId() == id) {
                            c.inputData(scanner, categories, products);
                            System.out.println("Cập nhật danh mục thành công!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã danh mục cần xóa: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    boolean canDelete = true;
                    for (Products p : products) {
                        if (p != null && p.getCategoryId() == deleteId) {
                            System.out.println("Không thể xóa vì có sản phẩm liên quan!");
                            canDelete = false;
                            break;
                        }
                    }
                    if (canDelete) {
                        for (int i = 0; i < count; i++) {
                            if (categories[i] != null && categories[i].getCateId() == deleteId) {
                                for (int j = i; j < count - 1; j++) {
                                    categories[j] = categories[j + 1];
                                }
                                categories[count - 1] = null;
                                count--;
                                System.out.println("Xóa danh mục thành công!");
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên danh mục cần tìm: ");
                    String name = scanner.nextLine();
                    for (Categories c : categories) {
                        if (c != null && c.getCateName().equalsIgnoreCase(name)) {
                            c.displayData();
                        }
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Chọn sai, vui lòng nhập lại!");
            }
        }
    }

    private static void productManagement(Scanner scanner, Categories[] categories, Products[] products, int count) {
        while (true) {
            System.out.println("\n********** PRODUCT MANAGEMENT **********");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (Products p : products) {
                        if (p != null) p.displayData();
                    }
                    break;
                case 2:
                    Products newProduct = new Products();
                    newProduct.inputData(scanner, categories, products);
                    products[count++] = newProduct;
                    System.out.println("Sản phẩm đã được thêm!");
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    String id = scanner.nextLine();
                    for (Products p : products) {
                        if (p != null && p.getProductId().equalsIgnoreCase(id)) {
                            p.inputData(scanner, categories, products);
                            System.out.println("Cập nhật sản phẩm thành công!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    String deleteId = scanner.nextLine();
                    for (int i = 0; i < count; i++) {
                        if (products[i] != null && products[i].getProductId().equalsIgnoreCase(deleteId)) {
                            products[i] = null;
                            System.out.println("Xóa sản phẩm thành công!");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên hoặc tiêu đề sản phẩm cần tìm: ");
                    String keyword = scanner.nextLine();
                    for (Products p : products) {
                        if (p != null && (p.getProductName().contains(keyword) || p.getTitle().contains(keyword))) {
                            p.displayData();
                        }
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Chọn sai, vui lòng nhập lại!");
            }
        }
    }
}

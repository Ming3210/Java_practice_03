package entity;

import java.util.Scanner;

public class Categories implements IApp {
    static int autoId = 0;

    private int cateId;
    private String cateName;
    private int priority;
    private String cateDescription;
    private boolean cateStatus;

    public Categories() {
        this.cateId = autoId++;
    }

    public Categories(String cateName, int priority, String cateDescription, boolean cateStatus) {
        this.cateId = autoId++;
        this.cateName = cateName;
        this.priority = priority;
        this.cateDescription = cateDescription;
        this.cateStatus = cateStatus;
    }

    public int getCateId() {
        return cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getCateDescription() {
        return cateDescription;
    }

    public void setCateDescription(String cateDescription) {
        this.cateDescription = cateDescription;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public boolean isCateStatus() {
        return cateStatus;
    }

    public void setCateStatus(boolean cateStatus) {
        this.cateStatus = cateStatus;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private boolean isDuplicateName(Categories[] existingCategories, String name, int currentId) {
        for (Categories c : existingCategories) {
            if (c != null && c.getCateId() != currentId && c.getCateName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void inputData(Scanner scanner, Categories[] existingCategories, Products[] existingProducts) {
        cateId = autoId;

        while (true) {
            System.out.print("Nhập tên danh mục (6-50 ký tự, không trùng): ");
            cateName = scanner.nextLine().trim();
            if (cateName.length() < 6 || cateName.length() > 50 || isDuplicateName(existingCategories, cateName,cateId)) {
                System.out.println("Tên danh mục không hợp lệ hoặc đã tồn tại, vui lòng nhập lại!");
            } else {
                break;
            }
        }

        System.out.print("Nhập độ ưu tiên: ");
        priority = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập mô tả danh mục (tối đa 255 ký tự): ");
        cateDescription = scanner.nextLine().trim();

        System.out.print("Nhập trạng thái (true - Hoạt động, false - Không hoạt động): ");
        cateStatus = scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.printf("%-5d %-20s %-5d %-25s %-5b%n", cateId, cateName, priority, cateDescription, cateStatus);
    }
}

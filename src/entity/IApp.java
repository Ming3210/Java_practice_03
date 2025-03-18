package entity;

import java.util.Scanner;

public interface IApp {
    double INTEREST = 1.1;

    void inputData(Scanner scanner, Categories[] existingCategories, Products[] existingProducts);
    void displayData();
}
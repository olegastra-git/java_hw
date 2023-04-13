import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class laptopstore {
    private final List<Laptop> laptops = new ArrayList<>();

    public laptopstore() {
        laptops.add(new Laptop(1, 8, 256, "Windows", "черный"));
        laptops.add(new Laptop(2, 16, 512, "MacOS", "серый"));
        laptops.add(new Laptop(3, 4, 128, "Ubuntu", "белый"));
        laptops.add(new Laptop(4, 16, 512, "Windows", "серебристый"));
        laptops.add(new Laptop(5, 8, 256, "Windows", "черный"));
    }

    public void filterLaptops() {
        Map<String, String> filters = getFiltersFromUser();
        List<Laptop> filteredLaptops = applyFilters(filters);
        if (filteredLaptops.isEmpty()) {
            System.out.println("Ноутбуки, подходящие по заданным параметрам, не найдены.");
        } else {
            System.out.println("Найденные ноутбуки:");
            filteredLaptops.forEach(System.out::println);
        }
    }

    private Map<String, String> getFiltersFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();
        System.out.println("Введите критерий фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем SSD или HDD");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        String filterChoice = scanner.nextLine();
        switch (filterChoice) {
            case "1":
                System.out.print("Введите минимальный объем ОЗУ (в ГБ): ");
                int minRam = getIntFromUser(scanner);
                filters.put("RAM", String.valueOf(minRam));
                break;
            case "2":
                System.out.print("Введите минимальный объем SSD или HDD (в ГБ): ");
                int minSsdHdd = getIntFromUser(scanner);
                filters.put("SSD/HDD", String.valueOf(minSsdHdd));
                break;
            case "3":
                System.out.print("Введите название операционной системы: ");
                String os = scanner.nextLine().trim();
                filters.put("OS", os);
                break;
            case "4":
                System.out.print("Введите цвет: ");
                String color = scanner.nextLine().trim();
                filters.put("color", color);
                break;
            default:
                System.out.println("Некорректный ввод.");
                filters.putAll(getFiltersFromUser());
        }
        return filters;
    }

    private int getIntFromUser(Scanner scanner) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }
        return value;
    }

    private List<Laptop> applyFilters(Map<String, String> filters) {
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            boolean isMatch = true;
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                switch (key) {
                    case "RAM":
                        if (laptop.getRam() < Integer.parseInt(value)) {
                            isMatch = false;
                        }
                        break;
                    case "SSD/HDD":
                        if (laptop.getSsd() < Integer.parseInt(value)) {
                            isMatch = false;
                        }
                        break;
                    case "OS":
                        if (!laptop.getOs().equalsIgnoreCase(value)) {
                            isMatch = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase(value)) {
                            isMatch = false;
                        }
                        break;
                    default:
                        System.out.println("Некорректный критерий.");
                        isMatch = false;
                }
                if (!isMatch) {
                    break;
                }
            }
            if (isMatch) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
}
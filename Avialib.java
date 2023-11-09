import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Avialib {
    public static class Customer {
        private String fio;
        private String tel;
        private String date;
        private String address;

        public Customer(String fio, String tel, String date, String address) {
            this.fio = fio;
            this.tel = tel;
            this.date = date;
            this.address = address;
        }

        public String getFio() {
            return fio;
        }

        public String getTel() {
            return tel;
        }

        public String getDate() {
            return date;
        }

        public String getAddress() {
            return address;
        }
    }

    public static class Order {
        int price;
        int order_id;

        public Order( int price, int order_id){
            this.price = price;
            this.order_id = order_id;
        }

        public int getPrice() {
            return price;
        }

        public int getOrderID() {
            return order_id;
        }
    }

    public static class Provider {
        private String company_name;
        private String country;
        private String company_age;
        public Provider(String company_name, String country, String company_age) {
            this.company_name = company_name;
            this.company_age = company_age;
            this.country = country;
        }

        public String getCompanyName() {
            return company_name;
        }

        public String getCountry() {
            return country;
        }

        public String getCompanyAge() {
            return company_age;
        }

    }

    public static class Operation {
        private String order_operation;
        private String operation_date;
        private int order_id;
        private String tel;

        public Operation(String order_operation, String operation_date, int order_id, String tel) {
            this.order_operation = order_operation;
            this.operation_date = operation_date;
            this.order_id = order_id;
            this.tel = tel;
        }

        public String getOperation() {
            return order_operation;
        }

        public String getOperationDate() {
            return operation_date;
        }

        public int getOrderID() {
            return order_id;
        }

        public String getTel() {
            return tel;
        }
    }

    public static class DroppointDataBase {
        private List<Customer> customers;
        private List<Order> orders;
        private List<Provider> providers;
        private List<Operation> operations;
        private Scanner in;  // Добавлен Scanner как поле класса

        public DroppointDataBase() {
            customers = new ArrayList<>();
            orders = new ArrayList<>();
            providers = new ArrayList<>();
            operations = new ArrayList<>();
            in = new Scanner(System.in);  // Инициализация Scanner в конструкторе
        }

        public void addCustomer(Customer customer) {
            customers.add(customer);
        }

        public void addOrder(Order order) {
            orders.add(order);
        }

        public void addProvider(Provider provider) {
            providers.add(provider);
        }

        public void addOperation(Operation operation) {
            operations.add(operation);
        }

        public void printCustomerList() {
            if (customers.isEmpty()) {
                System.out.println("Список пользователей пуст");
            } else {
                System.out.println("Список пользователей:");
                System.out.println("----------------------------------");
                for (Customer customer : customers) {
                    System.out.println("ФИО: " + customer.getFio());
                    System.out.println("Телефон: " + customer.getTel());
                    System.out.println("Дата рождения: " + customer.getDate());
                    System.out.println("Адрес: " + customer.getAddress());
                    System.out.println("----------------------------------");
                }
            }
        }

        public void printProviderList() {
            if (providers.isEmpty()) {
                System.out.println("Список производителей пуст");
            } else {
                System.out.println("Список производителей:");
                System.out.println("----------------------------------");
                for (Provider provider : providers) {
                    System.out.println("Название компании: " + provider.getCompanyName());
                    System.out.println("Страна компании: " + provider.getCountry());
                    System.out.println("Год создания компании: " + provider.getCompanyAge());
                    System.out.println("----------------------------------");
                }
            }
        }

        public void printOrderList() {
            if (orders.isEmpty()) {
                System.out.println("Список заказов пуст");
            } else {
                System.out.println("Список заказов:");
                System.out.println("----------------------------------");
                for (Order order : orders) {
                    System.out.println("Цена: " + order.getPrice());
                    System.out.println("ID заказа: " + order.getOrderID());
                    System.out.println("----------------------------------");
                }
            }
        }

        public void printOperationList() {
            if (operations.isEmpty()) {
                System.out.println("Список операций пуст");
            } else {
                System.out.println("Список операций:");
                System.out.println("----------------------------------");
                for (Operation operation : operations) {
                    System.out.println("Операция: " + operation.getOperation());
                    System.out.println("Дата операции: " + operation.getOperationDate());
                    System.out.println("ID заказа: " + operation.getOrderID());
                    System.out.println("Телефон: " + (operation.getTel().isEmpty() ? "Нет данных" : operation.getTel()));
                    System.out.println("----------------------------------");
                }
            }
        }

        public Customer inputCustomerFromUser() {
            String fio;
            String tel;
            String date;
            String address;
            try {
                System.out.println("Введите ФИО: ");
                fio = in.nextLine();
                System.out.println("Введите номер телефона: ");
                tel = in.nextLine();
                System.out.println("Введите дату рождения: ");
                date = in.nextLine();
                System.out.println("Введите адрес: ");
                address = in.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return new Customer(fio, tel, date, address);
        }

        public Order inputOrderFromUser() {
            
            int price;
            int order_id;
            try {
                System.out.println("Введите цену: ");
                price = in.nextInt();
                System.out.println("Введите ID заказа: ");
                order_id = in.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return new Order( price, order_id);
        }

        public Provider inputTicketFromUser() {
            String company_name;
            String company_age;
            String country;
            
            try {
                System.out.println("Введите название компании: ");
                company_name= in.nextLine();
                System.out.println("Введите год создания компании: ");
                company_age = in.nextLine();
                System.out.println("Введите страну компании: ");
                country=in.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return new Provider(company_name, company_age, country);
        }

        public Operation inputOperationFromUser() {
            String ticket_operation;
            String operation_date;
            int ticket_id;
            String tel;
            try {
                System.out.println("Введите операцию: ");
                ticket_operation = in.nextLine();
                System.out.println("Введите дату операции: ");
                operation_date = in.nextLine();
                System.out.println("Введите ID заказа: ");
                ticket_id = Integer.parseInt(in.nextLine());
                System.out.println("Введите телефон: ");
                tel = in.nextLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return new Operation(ticket_operation, operation_date, ticket_id, tel);
        }

        public void closeScanner() {
            in.close();
        }
    }

    public static void main(String[] args) {
        DroppointDataBase droppointDataBase = new DroppointDataBase();

        Customer customer1 = droppointDataBase.inputCustomerFromUser();
        droppointDataBase.addCustomer(customer1);

        Order order1 = droppointDataBase.inputOrderFromUser();
        droppointDataBase.addOrder(order1);

        Provider ticket1 = droppointDataBase.inputTicketFromUser();
       droppointDataBase.addProvider(ticket1);

        Operation operation1 = droppointDataBase.inputOperationFromUser();
        droppointDataBase.addOperation(operation1);

        droppointDataBase.printCustomerList();
        droppointDataBase.printOrderList();
        droppointDataBase.printProviderList();
        droppointDataBase.printOperationList();

        droppointDataBase.closeScanner();  // Закрыть Scanner после использования
    }
}

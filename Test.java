public class Test {
    public static void main(String[] args) {

        Avialib.DroppointDataBase aviaDataBase = new Avialib.DroppointDataBase();

        Avialib.Customer customer = aviaDataBase.inputCustomerFromUser();
        aviaDataBase.addCustomer(customer);

        Avialib.Order order = aviaDataBase.inputOrderFromUser();
        aviaDataBase.addOrder(order);

        Avialib.Provider provider = aviaDataBase.inputTicketFromUser();
        aviaDataBase.addProvider(provider);

        Avialib.Operation operation = aviaDataBase.inputOperationFromUser();
        aviaDataBase.addOperation(operation);

        aviaDataBase.printCustomerList();
        aviaDataBase.printOrderList();
        aviaDataBase.printProviderList();
        aviaDataBase.printOperationList();
    }
}

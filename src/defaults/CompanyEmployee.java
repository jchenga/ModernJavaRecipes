package defaults;

public class CompanyEmployee implements Company, Employee {
    private String first;
    private String last;

    @Override
    public String getName() {
        return String.format("%s working for %s",
                Employee.super.getName(), Company.super.getName());
    }

    @Override
    public void convertCaffeineToCode() {
        System.out.println("Coding...");
    }


    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}

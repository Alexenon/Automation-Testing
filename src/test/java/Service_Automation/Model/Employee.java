package Service_Automation.Model;

public class Employee {

    private String id;

    private String employeeName;

    private String employeeAge;

    private String employeeSalary;

    public String getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge='" + employeeAge + '\'' +
                ", employeeSalary='" + employeeSalary + '\'' +
                '}';
    }


    public static class Builder{

        Employee employee;

        public Builder() {
            this.employee = new Employee();
        }

        public Builder setId(String id){
            employee.setId(id);
            return this;
        }

        public Builder setName(String name){
            employee.setEmployeeName(name);
            return this;
        }

        public Builder setAge(String age){
            employee.setEmployeeAge(age);
            return this;
        }

        public Builder setSalary(String salary){
            employee.setEmployeeSalary(salary);
            return this;
        }

        public Employee build(){
            return employee;
        }

    }

}

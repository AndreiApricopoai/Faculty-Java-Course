package Lab3.Compulsory;

public class Company implements Node, Comparable<Company> {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    @Override
    public String getNodeName() {
        return this.name;
    }

    @Override
    public int compareTo(Company o) {
        return (this.getNodeName().compareTo(o.getNodeName()));
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}

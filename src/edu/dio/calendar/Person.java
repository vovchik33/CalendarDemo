package edu.dio.calendar;

import java.util.UUID;

/**
 * Created by Vladimir V. Kravchenko on 20.05.2014.
 */
public class Person {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String mail;

    private Person(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.mail = builder.mail;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id='").append(id).append('\'');
        sb.append(", firstName='").append(lastName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append(", mail='").append(mail).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private UUID id;
        private String firstName;
        private String lastName;
        private int age;
        private String mail;

        public Builder() {
        }

        public Builder(Person person) {
            this.id = person.id;
            this.firstName = person.firstName;
            this.lastName = person.lastName;
            this.age = person.age;
            this.mail = person.mail;
        }

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setMail(String mail) {
            this.mail = mail;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}

package it.mytools.spring.db.pojo.tracker;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Wallet wallet;

    @Column(nullable = false, columnDefinition = "double default 0.0")
    @Min(0)
    private double amount;

    public Expense() {
    }

    public Expense(LocalDate date, String description, Wallet wallet, double amount) {
        setDate(date);
        setDescription(description);
        setWallet(wallet);
        setAmount(amount);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", date='" + getDate() + "'" +
                ", description='" + getDescription() + "'" +
                ", wallet='" + getWallet() + "'" +
                ", amount='" + getAmount() + "'" +
                "}";
    }
}

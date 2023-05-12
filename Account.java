class Account {
    private int balance; // Баланс на счёте

    // Конструктор класса "Счёт"
    public Account(int balance) {
        this.balance = balance;
    }

    // Метод для получения баланса на счёте
    public int getBalance() {
        return balance;
    }

    // Метод для снятия денег со счёта
    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Недостаточно средств на счёте!");
        } else {
            balance -= amount;
            System.out.println("Снято со счёта: " + amount);
        }
    }

    // Метод для пополнения счёта
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Пополнено на счёт: " + amount);
    }


    public static void main(String[] args) {
        Account account = new Account(10000); // Создаем объект класса "Счёт"
        System.out.println("Баланс на счёте: " + account.getBalance()); // Выводим баланс на счёте
        account.withdraw(50000); // Снимаем со счёта
        System.out.println("Баланс на счёте: " + account.getBalance()); // Выводим баланс на счёте
        account.deposit(1000); // Пополняем счёт
        System.out.println("Баланс на счёте: " + account.getBalance()); // Выводим баланс на счёте
    }

}
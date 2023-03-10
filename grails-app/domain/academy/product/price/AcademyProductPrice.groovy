package academy.product.price

class AcademyProductPrice {

    static enum Currency {
        USD, PLN, UAH
    }

    Currency currency

    Double price

    static constraints = {
        currency nullable: false
        price nullable: false
    }
}

package HotelReservation;

public enum DiscountType {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1.00);

    private double multiplayer;

    DiscountType(double multiplayer) {
        this.multiplayer = multiplayer;
    }

    public double getMultiplayer() {
        return this.multiplayer;
    }

    public static DiscountType parse(String discount) {
        if (discount.equals("SECONDVISIT")) {
            discount = "SECOND_VISIT";
        }

        return DiscountType.valueOf(discount);
    }

}
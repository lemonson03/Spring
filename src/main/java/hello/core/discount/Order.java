package hello.core.discount;

public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {

        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
    public int calculatePrice(){
        return itemPrice - discountPrice;
    }
    public int getDiscountPrice(){
        return discountPrice;
    }
    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
    @Override
    public String toString() {
        return memberId + ", " + itemName + ", " + itemPrice + ", " + discountPrice;
    }


}

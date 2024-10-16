package hello.core.order;

public interface OrderSerive {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}

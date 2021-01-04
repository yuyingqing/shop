import java.util.Date;

public class Order {
    private User user;
    //private Product product;//1个商品
    private Product products[];//多个商品
    private int ProductAmmount;//购买商品数量
    private float totalPrice;
    private float finalPay;
    private Date orderDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {//把订单和用户关联
        this.user = user;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getProductAmmount() {
        return ProductAmmount;
    }

    public void setProductAmmount(int productAmmount) {
        ProductAmmount = productAmmount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(float finalPay) {
        this.finalPay = finalPay;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}

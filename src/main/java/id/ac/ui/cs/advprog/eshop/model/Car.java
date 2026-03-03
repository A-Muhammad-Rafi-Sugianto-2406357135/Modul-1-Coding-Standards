package id.ac.ui.cs.advprog.eshop.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String carId;
    private String carName;
    private String carColor;
    private int carQuantity;
}
package modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha=LocalDate.now();
    private BigDecimal valorTotal = new BigDecimal(0);
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemsPedido> itemsPedido = new ArrayList<>();

    //**CONSTRUCTOR VACIO**
    public Pedido() {
    }

    //**CONSTRUCTOR**
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarItems(ItemsPedido itemsPedido){
//        itemsPedido.setPedido(this);
        this.itemsPedido.add(itemsPedido);
        this.valorTotal = this.valorTotal.add(itemsPedido.getPrecioTotal());
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

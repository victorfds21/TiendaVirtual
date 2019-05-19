
package base.pedido.persistencia;

import base.pedido.dominio.Pedido;

public interface PedidoDAO {
    
    boolean actualizarPedido (Pedido pedido);
}

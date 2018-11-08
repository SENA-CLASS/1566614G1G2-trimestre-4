package co.edu.sena.ejemplodao.controller.dao;

import co.edu.sena.ejemplodao.modelo.dto.ClienteDTO;
import co.edu.sena.ejemplodao.modelo.dto.ClientePkDTO;

import java.util.Collection;

public interface ClienteDAO {
    public int insert(ClienteDTO cliente);
    public int update(ClienteDTO cliente, ClientePkDTO llavePrimaria);
    public int delete(ClientePkDTO llave);
    public Collection<ClienteDTO> findAll();
    public ClienteDTO findPk(ClientePkDTO llave);
}

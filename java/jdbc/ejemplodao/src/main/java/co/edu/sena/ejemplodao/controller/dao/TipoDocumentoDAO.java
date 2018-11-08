package co.edu.sena.ejemplodao.controller.dao;

import co.edu.sena.ejemplodao.modelo.dto.ClienteDTO;
import co.edu.sena.ejemplodao.modelo.dto.ClientePkDTO;
import co.edu.sena.ejemplodao.modelo.dto.TipoDocumentoDTO;

import java.util.Collection;

public interface TipoDocumentoDAO {
    public int insert(TipoDocumentoDTO tipoDocumentoDTO);
    public int update(TipoDocumentoDTO tipoDocumentoDTO, String primaryKey);
    public int delete(String primaryKey);
    public Collection<TipoDocumentoDTO> findAll();
    public TipoDocumentoDTO findPk(String primaryKey);
}

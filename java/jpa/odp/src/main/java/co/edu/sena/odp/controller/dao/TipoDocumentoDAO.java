package co.edu.sena.odp.controller.dao;

import co.edu.sena.odp.model.entities.TipoDocumento;

import java.util.List;

public interface TipoDocumentoDAO<T extends TipoDocumento> extends InterfaceDao<T> {
    public List<TipoDocumento> findByDescripcion(String descripcion);
    public List<TipoDocumento> findByEstado(boolean estado);
    public List<TipoDocumento> findByLikeDescripcion(String descripcion);
    public List<TipoDocumento> findByLikeDocumento(String documento);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
    public List<TipoDocumento> findByLikeEstado(String documento);
    public List<TipoDocumento> findByLikeDocumentoJPQL(String documento);
}

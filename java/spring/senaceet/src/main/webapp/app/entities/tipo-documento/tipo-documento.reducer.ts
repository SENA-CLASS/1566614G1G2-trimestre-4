import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ITipoDocumento, defaultValue } from 'app/shared/model/tipo-documento.model';

export const ACTION_TYPES = {
  FETCH_TIPODOCUMENTO_LIST: 'tipoDocumento/FETCH_TIPODOCUMENTO_LIST',
  FETCH_TIPODOCUMENTO: 'tipoDocumento/FETCH_TIPODOCUMENTO',
  CREATE_TIPODOCUMENTO: 'tipoDocumento/CREATE_TIPODOCUMENTO',
  UPDATE_TIPODOCUMENTO: 'tipoDocumento/UPDATE_TIPODOCUMENTO',
  DELETE_TIPODOCUMENTO: 'tipoDocumento/DELETE_TIPODOCUMENTO',
  RESET: 'tipoDocumento/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ITipoDocumento>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type TipoDocumentoState = Readonly<typeof initialState>;

// Reducer

export default (state: TipoDocumentoState = initialState, action): TipoDocumentoState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_TIPODOCUMENTO_LIST):
    case REQUEST(ACTION_TYPES.FETCH_TIPODOCUMENTO):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_TIPODOCUMENTO):
    case REQUEST(ACTION_TYPES.UPDATE_TIPODOCUMENTO):
    case REQUEST(ACTION_TYPES.DELETE_TIPODOCUMENTO):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_TIPODOCUMENTO_LIST):
    case FAILURE(ACTION_TYPES.FETCH_TIPODOCUMENTO):
    case FAILURE(ACTION_TYPES.CREATE_TIPODOCUMENTO):
    case FAILURE(ACTION_TYPES.UPDATE_TIPODOCUMENTO):
    case FAILURE(ACTION_TYPES.DELETE_TIPODOCUMENTO):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_TIPODOCUMENTO_LIST):
      return {
        ...state,
        loading: false,
        totalItems: action.payload.headers['x-total-count'],
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_TIPODOCUMENTO):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_TIPODOCUMENTO):
    case SUCCESS(ACTION_TYPES.UPDATE_TIPODOCUMENTO):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_TIPODOCUMENTO):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/tipo-documentos';

// Actions

export const getEntities: ICrudGetAllAction<ITipoDocumento> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_TIPODOCUMENTO_LIST,
    payload: axios.get<ITipoDocumento>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<ITipoDocumento> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_TIPODOCUMENTO,
    payload: axios.get<ITipoDocumento>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ITipoDocumento> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_TIPODOCUMENTO,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ITipoDocumento> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_TIPODOCUMENTO,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ITipoDocumento> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_TIPODOCUMENTO,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});

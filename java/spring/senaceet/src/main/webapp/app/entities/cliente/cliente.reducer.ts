import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ICliente, defaultValue } from 'app/shared/model/cliente.model';

export const ACTION_TYPES = {
  FETCH_CLIENTE_LIST: 'cliente/FETCH_CLIENTE_LIST',
  FETCH_CLIENTE: 'cliente/FETCH_CLIENTE',
  CREATE_CLIENTE: 'cliente/CREATE_CLIENTE',
  UPDATE_CLIENTE: 'cliente/UPDATE_CLIENTE',
  DELETE_CLIENTE: 'cliente/DELETE_CLIENTE',
  RESET: 'cliente/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ICliente>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type ClienteState = Readonly<typeof initialState>;

// Reducer

export default (state: ClienteState = initialState, action): ClienteState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_CLIENTE_LIST):
    case REQUEST(ACTION_TYPES.FETCH_CLIENTE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_CLIENTE):
    case REQUEST(ACTION_TYPES.UPDATE_CLIENTE):
    case REQUEST(ACTION_TYPES.DELETE_CLIENTE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_CLIENTE_LIST):
    case FAILURE(ACTION_TYPES.FETCH_CLIENTE):
    case FAILURE(ACTION_TYPES.CREATE_CLIENTE):
    case FAILURE(ACTION_TYPES.UPDATE_CLIENTE):
    case FAILURE(ACTION_TYPES.DELETE_CLIENTE):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_CLIENTE_LIST):
      return {
        ...state,
        loading: false,
        totalItems: action.payload.headers['x-total-count'],
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_CLIENTE):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_CLIENTE):
    case SUCCESS(ACTION_TYPES.UPDATE_CLIENTE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_CLIENTE):
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

const apiUrl = 'api/clientes';

// Actions

export const getEntities: ICrudGetAllAction<ICliente> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_CLIENTE_LIST,
    payload: axios.get<ICliente>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<ICliente> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_CLIENTE,
    payload: axios.get<ICliente>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ICliente> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_CLIENTE,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ICliente> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_CLIENTE,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ICliente> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_CLIENTE,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});

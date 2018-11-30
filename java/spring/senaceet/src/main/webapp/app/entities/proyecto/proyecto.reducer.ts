import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IProyecto, defaultValue } from 'app/shared/model/proyecto.model';

export const ACTION_TYPES = {
  FETCH_PROYECTO_LIST: 'proyecto/FETCH_PROYECTO_LIST',
  FETCH_PROYECTO: 'proyecto/FETCH_PROYECTO',
  CREATE_PROYECTO: 'proyecto/CREATE_PROYECTO',
  UPDATE_PROYECTO: 'proyecto/UPDATE_PROYECTO',
  DELETE_PROYECTO: 'proyecto/DELETE_PROYECTO',
  RESET: 'proyecto/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IProyecto>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type ProyectoState = Readonly<typeof initialState>;

// Reducer

export default (state: ProyectoState = initialState, action): ProyectoState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_PROYECTO_LIST):
    case REQUEST(ACTION_TYPES.FETCH_PROYECTO):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_PROYECTO):
    case REQUEST(ACTION_TYPES.UPDATE_PROYECTO):
    case REQUEST(ACTION_TYPES.DELETE_PROYECTO):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_PROYECTO_LIST):
    case FAILURE(ACTION_TYPES.FETCH_PROYECTO):
    case FAILURE(ACTION_TYPES.CREATE_PROYECTO):
    case FAILURE(ACTION_TYPES.UPDATE_PROYECTO):
    case FAILURE(ACTION_TYPES.DELETE_PROYECTO):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_PROYECTO_LIST):
      return {
        ...state,
        loading: false,
        totalItems: action.payload.headers['x-total-count'],
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_PROYECTO):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_PROYECTO):
    case SUCCESS(ACTION_TYPES.UPDATE_PROYECTO):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_PROYECTO):
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

const apiUrl = 'api/proyectos';

// Actions

export const getEntities: ICrudGetAllAction<IProyecto> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_PROYECTO_LIST,
    payload: axios.get<IProyecto>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IProyecto> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_PROYECTO,
    payload: axios.get<IProyecto>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IProyecto> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_PROYECTO,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IProyecto> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_PROYECTO,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IProyecto> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_PROYECTO,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});

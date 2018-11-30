import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IFase, defaultValue } from 'app/shared/model/fase.model';

export const ACTION_TYPES = {
  FETCH_FASE_LIST: 'fase/FETCH_FASE_LIST',
  FETCH_FASE: 'fase/FETCH_FASE',
  CREATE_FASE: 'fase/CREATE_FASE',
  UPDATE_FASE: 'fase/UPDATE_FASE',
  DELETE_FASE: 'fase/DELETE_FASE',
  RESET: 'fase/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IFase>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type FaseState = Readonly<typeof initialState>;

// Reducer

export default (state: FaseState = initialState, action): FaseState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_FASE_LIST):
    case REQUEST(ACTION_TYPES.FETCH_FASE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_FASE):
    case REQUEST(ACTION_TYPES.UPDATE_FASE):
    case REQUEST(ACTION_TYPES.DELETE_FASE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_FASE_LIST):
    case FAILURE(ACTION_TYPES.FETCH_FASE):
    case FAILURE(ACTION_TYPES.CREATE_FASE):
    case FAILURE(ACTION_TYPES.UPDATE_FASE):
    case FAILURE(ACTION_TYPES.DELETE_FASE):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_FASE_LIST):
      return {
        ...state,
        loading: false,
        totalItems: action.payload.headers['x-total-count'],
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_FASE):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_FASE):
    case SUCCESS(ACTION_TYPES.UPDATE_FASE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_FASE):
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

const apiUrl = 'api/fases';

// Actions

export const getEntities: ICrudGetAllAction<IFase> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_FASE_LIST,
    payload: axios.get<IFase>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IFase> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_FASE,
    payload: axios.get<IFase>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IFase> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_FASE,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IFase> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_FASE,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IFase> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_FASE,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});

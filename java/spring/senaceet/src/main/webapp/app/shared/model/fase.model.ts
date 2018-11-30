import { Moment } from 'moment';
import { IProyecto } from 'app/shared/model//proyecto.model';

export const enum Estado {
  ACTIVO = 'ACTIVO',
  INACTIVO = 'INACTIVO'
}

export interface IFase {
  id?: number;
  nombre?: string;
  estado?: Estado;
  hora?: Moment;
  proyecto?: IProyecto;
}

export const defaultValue: Readonly<IFase> = {};

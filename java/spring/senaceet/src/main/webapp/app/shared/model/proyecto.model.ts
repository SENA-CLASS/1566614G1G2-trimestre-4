import { IFase } from 'app/shared/model//fase.model';

export const enum Estado {
  ACTIVO = 'ACTIVO',
  INACTIVO = 'INACTIVO'
}

export interface IProyecto {
  id?: number;
  codigo?: string;
  nombre?: string;
  estado?: Estado;
  fases?: IFase[];
}

export const defaultValue: Readonly<IProyecto> = {};

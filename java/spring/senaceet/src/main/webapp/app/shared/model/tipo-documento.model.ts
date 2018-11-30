import { ICliente } from 'app/shared/model//cliente.model';

export const enum Estado {
  ACTIVO = 'ACTIVO',
  INACTIVO = 'INACTIVO'
}

export interface ITipoDocumento {
  id?: number;
  sigla?: string;
  nombreDocumento?: string;
  estado?: Estado;
  clientes?: ICliente[];
}

export const defaultValue: Readonly<ITipoDocumento> = {};

import { ITipoDocumento } from 'app/shared/model//tipo-documento.model';
import { IUser } from 'app/shared/model/user.model';

export interface ICliente {
  id?: number;
  numeroDocumento?: string;
  primerNombre?: string;
  segundoNombre?: string;
  primerApellido?: string;
  segundoApellido?: string;
  tipoDocumento?: ITipoDocumento;
  user?: IUser;
}

export const defaultValue: Readonly<ICliente> = {};

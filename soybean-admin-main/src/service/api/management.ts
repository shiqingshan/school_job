import { adapter } from '@/utils';
import { mockRequest, request } from '../request';
import { adapterOfFetchUserList, adapterOfFetchRoleList } from './management.adapter';

/** 获取用户列表 */
export const fetchUserList = async () => {
  const data = await mockRequest.post<ApiUserManagement.User[] | null>('/getAllUserList');
  return adapter(adapterOfFetchUserList, data);
};

/** 获取角色列表 */
export const fetchRoleList = async () => {
  const data = await request.get<ApiRoleManagement.Role[] | null>('/role/list');
  return adapter(adapterOfFetchRoleList, data);
};

/** 添加角色 */
export const saveRole = async (data: ApiRoleManagement.Role) => {
  return request.post<ApiRoleManagement.Role>('/role/add', data);
};

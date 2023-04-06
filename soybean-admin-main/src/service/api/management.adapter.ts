export function adapterOfFetchUserList(data: ApiUserManagement.User[] | null): UserManagement.User[] {
  if (!data) return [];

  return data.map((item, index) => {
    const user: UserManagement.User = {
      index: index + 1,
      key: item.id,
      ...item
    };

    return user;
  });
}

export function adapterOfFetchRoleList(data: ApiRoleManagement.Role[] | null): RoleManagement.Role[] {
  if (!data) return [];

  return data.map((item, index) => {
    const role: RoleManagement.Role = {
      index: index + 1,
      key: item.id,
      ...item
    };

    return role;
  });
}

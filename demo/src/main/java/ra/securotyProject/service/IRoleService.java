package ra.securotyProject.service;


import ra.securotyProject.model.domain.Role;
import ra.securotyProject.model.domain.RoleName;
import ra.securotyProject.model.domain.RoleOrder;
import ra.securotyProject.model.domain.RoleOrderName;

public interface IRoleService {
    Role findByRoleName(RoleName roleName);
    RoleOrder findByRoleOrderName(RoleOrderName roleOrderName);
}

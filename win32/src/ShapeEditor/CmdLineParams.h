// CmdLineParams.h: ���������в����ӿ�
//

#ifndef _APP_ICMDLINE_PARAMS_H
#define _APP_ICMDLINE_PARAMS_H

//! ���������в���
bool SetCmdLineParams(LPCTSTR cmdLine);

//! ��ѯ�����в���
/*!
    \param[in] name �������ƣ�û�б�����
    \param[out] value �����ΪNULL����������Ӧ��ֵ
    \return ���������Ƿ��д˲���
*/
bool FindCmdLineParam(LPCTSTR name, LPCTSTR* value = NULL);

//! ȥ��һ�������в���
bool RemoveCmdLineParam(LPCTSTR name);

#endif // _APP_ICMDLINE_PARAMS_H

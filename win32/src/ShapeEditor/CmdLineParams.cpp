#include "stdafx.h"
#include "CmdLineParams.h"

static CStringArray s_tokens;
static CStringArray s_pics;
static CStringArray s_lrcs;

static bool GetToken(CString& token, LPCTSTR& cmdLine)
{
    token.Empty();
	while (iswspace(*cmdLine))      // �����հ��ַ�
		cmdLine++;
	
	LPCTSTR start = cmdLine;        // ��һ���ǿհ��ַ�

	if ('\"' == *start)            // ��������ſ�ʼ
	{
		while (*(++cmdLine) && *cmdLine != '\"') ;         // �ҵ���һ������
		token = CString(start + 1, cmdLine - start - 1);    // ȡ��������֮���
	}
	else
	{
        while (*cmdLine && !iswspace(*(++cmdLine)))         // ����һ���հ��ַ�
        {
            if ('\"' == *cmdLine)                          // ��������
            {
                token = CString(start, cmdLine - start);    // ��ȡ����ǰ��
                start = cmdLine;
                while (*(++cmdLine) && *cmdLine != '\"') ; // �ҵ���һ�����ţ������ո�
                token += CString(start + 1, cmdLine - start - 1);    // ���Ϻ����
                break;                                      // �����ҿհ��ַ�
            }
        }
        if (token.IsEmpty())
		    token = CString(start, cmdLine - start);
	}

	if (*cmdLine)
		cmdLine++;                                  // �����հ��ַ�������

	return !token.IsEmpty();
}

static bool _FindCmdLineParam(LPCTSTR name, LPCTSTR* value, bool remove)
{
    int i = s_tokens.GetSize();
    LPCTSTR post = _T("");
    static CString token;

    while (--i >= 0)
    {
        token = s_tokens.GetAt(i);

        if (!token.IsEmpty() && token[0] == '-' && token.Find(name, 1) >= 0)
        {
            post = (LPCTSTR)token + 1 + _tcslen(name);
            if (*post == 0 || *post == ':' || *post == '=')
            {
                if (*post != 0)
                    post++;
                if (*post == 0 && i + 1 < s_tokens.GetSize())
                {
                    token = s_tokens.GetAt(i + 1);
                    post = (LPCTSTR)token;
                    if (*post == '-')
                        post = _T("");
                    if (remove)
                        s_tokens.RemoveAt(i + 1);
                }
                if (remove)
                    s_tokens.RemoveAt(i);
                break;
            }
        }
    }
    if (value) {
        *value = post;
    }

    return i >= 0;
}

bool SetCmdLineParams(LPCTSTR cmdLine)
{
    CString token;
    LPCTSTR value;

    // ������һ�������еĵ����ļ���
    while (FindCmdLineParam(_T("pic"), &value))
    {
        s_pics.Add(value);
        _FindCmdLineParam(_T("pic"), NULL, true);
        
        FindCmdLineParam(_T("lrc"), &value);
        s_lrcs.Add(value);
        _FindCmdLineParam(_T("lrc"), NULL, true);
    }

    // �ı�������
    s_tokens.RemoveAll();
	while (GetToken(token, cmdLine))
	{
		if (token[0] == '/')
			token.SetAt(0, '-');
        s_tokens.Add(token);
	}

    return s_tokens.GetSize() > 0;
}

bool FindCmdLineParam(LPCTSTR name, LPCTSTR* value)
{
    return _FindCmdLineParam(name, value, false);
}

bool RemoveCmdLineParam(LPCTSTR name)
{
    bool ret = _FindCmdLineParam(name, NULL, true);

    if (_tcscmp(name, _T("pic")) == 0 && s_pics.GetSize() > 0)
    {
        s_tokens.Add(_T("-pic:"));
        s_tokens.Add(s_pics[0]);
        s_pics.RemoveAt(0);
    }

    if (_tcscmp(name, _T("lrc")) == 0 && s_lrcs.GetSize() > 0)
    {
        s_tokens.Add(_T("-lrc:"));
        s_tokens.Add(s_lrcs[0]);
        s_lrcs.RemoveAt(0);
    }

    return ret;
}

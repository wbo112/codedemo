#include <stdlib.h>
#include <string.h>
#include <iostream>
#include "SecKeyShm.h"
using namespace std;

SecKeyShm::SecKeyShm(int key):ShareMemory(key)
{
	
}

SecKeyShm::SecKeyShm(int key, int maxNode):
	ShareMemory(key, sizeof(int) + maxNode*sizeof(NodeSHMInfo)), m_maxNode(maxNode)
{
	//���ӹ����ڴ�
	void *p = mapShm();
	
	//��ʼ�������ڴ�
	memset(p, 0x00, sizeof(int) + maxNode*sizeof(NodeSHMInfo));
	
	//��maxNodeд�빲���ڴ��ͷ4���ֽ�
	memcpy(p, &m_maxNode, sizeof(int));
	
	//�Ͽ��빲���ڴ������
	unmapShm();
}

SecKeyShm::SecKeyShm(const char* pathName): ShareMemory(pathName)
{
	
}

SecKeyShm::SecKeyShm(const char* pathName, int maxNode):
	ShareMemory(pathName, sizeof(int) + maxNode*sizeof(NodeSHMInfo)), m_maxNode(maxNode)
{
	//���ӹ����ڴ�
	void *p = mapShm();
	
	//��ʼ�������ڴ�
	memset(p, 0x00, sizeof(int) + maxNode*sizeof(NodeSHMInfo));
	
	//��maxNodeд�빲���ڴ��ͷ4���ֽ�
	memcpy(p, &m_maxNode, sizeof(int));
	
	//�Ͽ��빲���ڴ������
	unmapShm();
}

SecKeyShm::~SecKeyShm()
{
	
}

int SecKeyShm::shmWrite(NodeSHMInfo* pNodeInfo)
{
	//���ӹ����ڴ�
	void *p = mapShm();
	
	//��ͷ4���ֽڻ�ȡmaxNode
	memcpy(&m_maxNode, p, sizeof(int));
	cout << "maxNode:" << m_maxNode << endl;
	
	NodeSHMInfo *pNode = (NodeSHMInfo *)((char *)p+sizeof(int));
	
	//�Ȳ���ԭ�е�
	int i = 0;
	for(i=0; i<m_maxNode; i++)
	{
		if(strcmp(pNodeInfo->clientID, pNode[i].clientID)==0 &&
		   strcmp(pNodeInfo->serverID, pNode[i].serverID)==0)
		{
			memcpy(&pNode[i], pNodeInfo, sizeof(NodeSHMInfo));
			break;
		}
	}
	
	//û�ҵ�ԭ�е�, ��һ�����п��õ�
	NodeSHMInfo tmp;
	memset(&tmp, 0x00, sizeof(NodeSHMInfo));
	if(i==m_maxNode)
	{
		for(i=0; i<m_maxNode; i++)
		if(memcmp(&pNode[i], &tmp, sizeof(NodeSHMInfo))==0) 
		{
			memcpy(&pNode[i], pNodeInfo, sizeof(NodeSHMInfo));
			break;
		}
	}
	
	//�Ͽ��빲���ڴ�Ĺ���
	unmapShm();
	
	//û�п���λ�ÿ���
	if(i==m_maxNode)
	{
		cout << "no space to use" << endl;
		return -1;
	}
	
	return 0;
}

int SecKeyShm::shmRead(const char* clientID, const char* serverID, NodeSHMInfo* pNodeInfo)
{
	//���ӹ����ڴ�
	void *p = mapShm();
	
	//��ͷ4���ֽڻ�ȡmaxNode
	memcpy(&m_maxNode, p, sizeof(int));
	cout << "maxNode:" << m_maxNode << endl;
	
	NodeSHMInfo *pNode = (NodeSHMInfo *)((char *)p+sizeof(int));
	
	int i = 0;
	for(i=0; i<m_maxNode; i++)
	{
		if(strcmp(clientID, pNode[i].clientID)==0 &&
		   strcmp(serverID, pNode[i].serverID)==0)
		{
			memcpy(pNodeInfo, &pNode[i], sizeof(NodeSHMInfo));
			break;
		}
	}
	
	//�Ͽ��빲���ڴ�Ĺ���
	unmapShm();
	
	//û���ҵ��ڵ�
	if(i==m_maxNode)
	{
		cout << "not found" << endl;
		return -1;
	}
	
	return 0;
}

void SecKeyShm::printShm()
{
	//���ӹ����ڴ�
	void *p = mapShm();
	
	//��ͷ4���ֽڻ�ȡmaxNode
	memcpy(&m_maxNode, p, sizeof(int));
	cout << "maxNode:" << m_maxNode << endl;
	
	NodeSHMInfo *pNode = (NodeSHMInfo *)((char *)p+sizeof(int));
	
	int i = 0;
	for(i=0; i<m_maxNode; i++)
	{
		cout << "-------" << i << "-------" << endl;
		cout << "status:" << pNode[i].status << endl;
		cout << "seckeyID:" << pNode[i].seckeyID << endl;
		cout << "clientID:" << pNode[i].clientID << endl;
		cout << "serverID:" << pNode[i].serverID << endl;
		cout << "seckey:" << pNode[i].seckey << endl;
	}
	
	return;
}

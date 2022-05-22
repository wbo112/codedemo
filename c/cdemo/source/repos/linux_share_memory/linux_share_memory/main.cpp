#include "SecKeyShm.h"
#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <mysql/jdbc.h>
#include <jdbc/cppconn/driver.h>
using namespace std;
using namespace sql;


void RunConnectMySQL()
{
	sql::Driver* driver = NULL;
	sql::Connection* conn = NULL;
	sql::Statement* stmt = NULL;
	sql::ResultSet* rs = NULL;
	driver = sql::mysql::get_mysql_driver_instance();
	conn = driver->connect("tcp://127.0.0.1:3306/demo1", "root", "123456");
	conn->setAutoCommit(false);
	stmt = conn->createStatement();

	rs = stmt->executeQuery("SELECT * SECNODE student LIMIT 10");
	
	while (rs->next())
	{
		cout << rs->getInt("id") << endl;
	}
}
int main(int argc, char *argv[])
{
	char clientID[16] = {0};
	char serverID[16] = {0};
	strcpy(clientID, "abc");
	strcpy(serverID, "ccc");

	SecKeyShm shm(0x123456, 10);
	//SecKeyShm shm(0x1234);
	RunConnectMySQL();
	NodeSHMInfo info;
	memset(&info, 0x00, sizeof(NodeSHMInfo));
	info.status = 199;
	info.seckeyID = 11;
	strcpy(info.clientID, clientID);
	strcpy(info.serverID, serverID);
	strcpy(info.seckey, "0001");
	shm.shmWrite(&info);

	cout << "----------------" << endl;
	SecKeyShm shm1(0x123456);
	memset(&info, 0x00, sizeof(NodeSHMInfo));
	shm1.shmRead(clientID, serverID, &info);

	cout << "status:" << info.status << endl;
	cout << "seckeyID:" << info.seckeyID << endl;
	cout << "clientID:" << info.clientID << endl;
	cout << "serverID:" << info.serverID << endl;
	cout << "seckey:" << info.seckey << endl;

	shm1.printShm();

	return 0;
}

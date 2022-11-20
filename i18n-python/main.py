#!/usr/bin/env python3

import os
import psutil
import platform
import socket
from requests import get
import gettext



def main():
    gettext.install(domain="messages", localedir="locales", codeset="UTF-8")

    print(_('***SYSTEM INFORMATION***\n'))

    print(_('Operative System: {}').format(platform.platform()))

    print(_('System OS name: {}').format(platform.system()))

    print(_('System architecture: {}').format(platform.machine()))

    print(_('Your Computer IP Address is:') +socket.gethostbyname(socket.gethostname()))  

    ip = get('https://api.ipify.org').content.decode('utf8')
    print(_('Your public IP address is: {}').format(ip))

    print(_('CPU usage is {} %').format(get_cpu_usage_pct()))

    print(_('RAM usage is {} MB').format(int(get_ram_usage() / 1024 / 1024)))

    print(_('RAM total is {} MB').format(int(get_ram_total() / 1024 / 1024)))

    print(_('RAM usage is {} %').format(get_ram_usage_pct()))


def get_cpu_usage_pct():
    return psutil.cpu_percent(interval=0.5)


def get_ram_usage():
    return int(psutil.virtual_memory().total - psutil.virtual_memory().available)


def get_ram_total():
    return int(psutil.virtual_memory().total)


def get_ram_usage_pct():
    return psutil.virtual_memory().percent


if __name__ == "__main__":
    main() 